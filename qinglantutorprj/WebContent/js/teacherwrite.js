KindEditor.create('textarea.kindeditorSimple', {
    basePath: '/dist/lib/kindeditor/',
    bodyClass : 'article-content',
    resizeType : 1,
    allowPreviewEmoticons : false,
    allowImageUpload : false,
    items : [
        'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
        'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
        'insertunorderedlist', '|', 'emoticons', 'image', 'link'
    ]
});