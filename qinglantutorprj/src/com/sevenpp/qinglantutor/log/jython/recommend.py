#!/usr/bin/python
# -*- coding:UTF-8 -*-
#   第十章
#   胡宇

import sys
import random
import math
import os
from operator import itemgetter

from collections import defaultdict

random.seed(0)

trainset = {}
testset = {}
user_sim_mat = {}

'''加载文件'''
def loadfile(filename):
    # 以只读的方式打开传入的文件
    fp = open(filename, 'r+')
    for i, line in enumerate(fp):
        yield line.strip('\r\n')
    fp.close()


'''划分训练集和测试集 pivot用来定义训练集和测试集的比例'''
def generate_dataset(filename, pivot=0.7):
    ''' load rating data and split it to training set and test set '''
    trainset_len = 0

    for line in loadfile(filename):
        # 根据 分隔符 \t 来切分每行数据
        user, scan_log, rating, _ = line.split('\t')
        trainset.setdefault(user, {})
        # 以下省略格式如下，会产生一个集同一个用户id 字典，且值为他浏览过的所有记录
        #{'1': {'914': 3, '3408': 4, '150': 5, '1': 5}, '2': {'1357': 5}}
        trainset[user][scan_log] = int(rating)
        trainset_len += 1


''' 建立物品-用户 倒排表'''
def calc_user_sim(id):

    # print ('构建物品-用户倒排表中，请等待......', file=sys.stderr)
    scan_log2users = dict()

    # Python 字典(Dictionary) items() 函数以列表返回可遍历的(键, 值) 元组数组
    for user, scan_logs in trainset.items():
        for scan_log in scan_logs:
            # inverse table for item-users
            if scan_log not in scan_log2users:
                # 根据文章id 构造set() 函数创建一个无序不重复元素集
                scan_log2users[scan_log] = set()
            # 数值形如
            # {'914': {'1','6','10'}, '3408': {'1'} ......}
            scan_log2users[scan_log].add(user)

    usersim_mat = user_sim_mat

    # 令系数矩阵 C[u][v]表示N(u)∩N（v) ，假如用户u和用户v同时属于K个物品对应的用户列表，就有C[u][v]=K
    for scan_log, users in scan_log2users.items():
        for u in users:
            usersim_mat.setdefault(u, defaultdict(int))
            for v in users:
                if u == v:
                    continue
                usersim_mat[u][v] += 1

    simfactor_count = 0
    # 循环遍历usersim_mat 根据余弦相似度公式计算出用户兴趣相似度
    for u, related_users in usersim_mat.items():
        for v, count in related_users.items():
            # 以下是公式计算过程
            usersim_mat[u][v] = count / math.sqrt(
                len(trainset[u]) * len(trainset[v]))
            #计数
            simfactor_count += 1

    '''userid的多少个顺序数据'''
    usersim_mat = sorted(usersim_mat[id].items(),key=itemgetter(1),reverse=True)

    usersim_mat.sort(key=lambda x: int(x[0]), reverse=True)

    return usersim_mat

''' 得到指定用户的家教详情页的浏览记录 '''
def scan_teacher_log(user_list, id, filename):
    teacher_log = {}
    tutor_log = []
    tutor = []
    for line in loadfile(filename):
        user, scan_log, rating, _ = line.split('\t')
        teacher_log.setdefault(user, {})
        teacher_log[user][scan_log] = int(rating)
    #   得到用户的家教浏览记录
    user_id = list(map(int, teacher_log[id].keys()))


    #  得到相似用户的家教浏览记录，将相似用户中有的，该用户中没有的放入一个数组
    for i in range(len(user_list)):
        if(user_list[i] in teacher_log.keys()):
            tutor_log = list(map(int,teacher_log[user_list[i]].keys()))
            tutor.extend([x for x in tutor_log if x not in user_id])

    #   将重复的浏览的家教记录计数，去除前8个公共的最对的家教id
    a = {}
    for i in tutor:
        if tutor.count(i) > 1:
            a[i] = tutor.count(i)
    a = sorted(a.items(), key=lambda item: item[1],reverse=True)
    a = dict(a[:3]).keys()
    
    
    return a 


'''将两个相似度的合并成一个字典，家教的70%  文章的30%  '''
def func(dict1,dict2):
    for i,j in dict2.items():
        if i in dict1.keys():
            dict1[i] = dict1[i]*0.3 + j*0.7
        else:
            dict1.update({'i':dict2[i]*0.7})
    return dict1


def tutor(id,basePath):
    '''得到用户浏览家教老师得到相似用户'''
    generate_dataset(basePath+'\\tutorDetail_log.txt')
    scan_tutor_log = calc_user_sim(id)

    '''得到用户浏览文章得到的相似用户'''
    generate_dataset(basePath+'\\article_log.txt')
    scan_article_log = calc_user_sim(id)

    a = dict(scan_article_log)
    b = dict(scan_tutor_log)
    c = func(a,b)

    user_list = []
    total_list = sorted(c.items(),key=lambda x:x[1],reverse=True)
    user_list = list(map(str,dict(total_list).keys()))

    return scan_teacher_log(user_list,id,basePath+'\\tutorDetail_log.txt')
    

