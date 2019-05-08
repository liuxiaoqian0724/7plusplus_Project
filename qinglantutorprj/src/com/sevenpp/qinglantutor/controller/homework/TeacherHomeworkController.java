package com.sevenpp.qinglantutor.controller.homework;

import com.sevenpp.qinglantutor.service.impl.HomeworkSelectServiceImpl;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;

@Controller
public class TeacherHomeworkController {
	@Resource HomeworkSelectServiceImpl homeworkSelectServiceImpl;
}
