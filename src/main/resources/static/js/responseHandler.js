$(function () {
    $('input').click(function () {
        let checkedAnswer = $('input[name=answer]:checked').val();
        $.ajax ({
            url: '/questionnaire',
            type: 'post',
            data: {answer: checkedAnswer}
        })
    })
})