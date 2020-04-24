/**
 * 
 */

	$(document).ready(function() {
        $('#contents').summernote({
			height:400	  
		  });
    });
	
	
	$('#wrBtn').on("click",function(){
		//title, contents 데이터 유무 검증
		var title = $('#title').val();
		var contents= $('#contents').val();
		console.log(title=='');
		console.log(contents=='');
		console.log(title.length);
		console.log(contents.length);
		
		console.log($('#contents').summernote('isEmpty'));
		contents = $("#contents").summernote('code');
		
		var ch1 = title!='';
		var ch2 = contents !='';
		var ch3 = true;
		
		$(".files").each(function() {
			if($(this).val()==''){
				ch3=false;
			}
		});
		
		if(ch1 && ch2 && ch3){
			//form 전송 (submit event 강제 발생)
			$('#frm').submit();
		} else{
			//submit event 종료
			alert("항목을 모두 작성하세요");
		}			
	});
	
	
	var cnt =1;
	$('#add').click(function(){
		if(cnt<6){
			$('#file').append('<div class="form-group" id="f'+cnt+'">	 <label for="files">File :</label><input type="file" class="form-control files" name="files"><i class="glyphicon glyphicon-remove remove"></i> </div>');
			cnt++;
		} else{
			alert('파일은 최대 5개');
		}	
	});
	
	
	$('#file').on("click",".remove",function(){
		$(this).parent().remove();
		cnt--;
	});