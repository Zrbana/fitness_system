$.extend($,{
    pairArrayToMap:function (pairArray,key,valueKey){
        var result = {};
        if(!key){
            return pairArray;
        }
        pairArray.forEach(function(item,index){
            if(valueKey){
                result[item[key]] = item[valueKey];
            }else{
                result[item[key]] = item;
            }
        });
        return result;
    },
    closePage:function(event){
        if(window.parent !=window){
            event.preventDefault();
            event.stopPropagation();
            window.parent.postMessage({action:'close'},'*')
        }else{

        }
    },
    unbind:function(title,message,url){
        $.confirm({
            title: title,
            text: message,
            onOK: function () {
                window.open(url,'_blank');
            },
            onCancel: function () {
            }
        });
    }
}
);


$(function(){
    $('.js-help').on('click',function(){
        $('.js-help-links').toggle(100);
    });
    $('#qrlogin_btn_popup').on('click',function(){
        $('#qrlogin_container').show();
    })
    $('#qrlogin_btn_normal').on('click',function(){
        $('#normal_login_form').hide();
        $('#qrlogin_container').show();
        $(this).hide();
        $('#normal_login_btn').show();
    })
    $('#normal_login_btn').on('click',function(){
        $('#qrlogin_container').hide();
        $('#normal_login_form').show();
        $(this).hide();
        $('#qrlogin_btn_normal').show();
    })
    $('#qrlogin_close').on('click',function(){
        $('.qrlogin_container_mask').hide();
    })
    $('[data-tooltip]').qtip({
        style: {
            classes: 'qtip-shadow qtip-tipsy'
        },
        content:{
            text:function(event, api) {
                // Retrieve content from custom attribute of the $('.selector') elements.
                return $(this).data('tooltip');
            }

        },
        position: {
            target: 'mouse',
            adjust: {
                mouse: true,
                scroll:false,
            }
        }
    })

    $('button.submit').click(function(event){
        $(event.target).addClass('weui-btn_loading').attr('disabled',true);
        $(event.target).parents('form').submit();
        return false;
    });
})
