/**
 * 
 */


	var cnt =1;
	
	$('#file').on("click",".remove",function(){
		$(this).parent().remove();
		cnt--;
	});
	
	
	$('#add').click(function(){
		if(cnt<6){
			$('#file').append('<div class="form-group" id="f'+cnt+'">	 <label for="files">File :</label><input type="file" class="form-control files" name="files"><i class="glyphicon glyphicon-remove remove"></i> </div>');
			cnt++;
		} else{
			alert('파일은 최대 5개');
		}	
	});


/////////////////////////////////////////////////////////
/*
	$(document).ready(function() {
        $('#contents').summernote({
			height:400,	
			callbacks: {
			    onImageUpload: function(files) {
			     console.log("upload");
			    
			    }
			  }
		  });
    });
    */
	//////////////////////////////////////////////////////////////////////////
	
	
        $('#contents').summernote({
			height:400,	
			callbacks: {
				
			    onImageUpload: function(files, editor) {
			    	var formData = new FormData();	//<form></form>
			    	formData.append('files',files[0]);	//<input type="file" name="files">
			    	
			    	$.ajax({
			    		type:"POST",
			    		url : "../boardFile/fileInsert",
			    		data: formData, 
			    		enctype: "multipart/form-data",
			    		cache:false,
			    		contentType:false,
			    		processData:false,
			    		success:function(imageName){
			    			imageName = imageName.trim();
			    			$("#contents").summernote('editor.insertImage',imageName);
			    		}
			    	});
			    },///onImageUpload
			    
			    onMediaDelete:function(files){
			    	var fileName = $(files[0]).attr("src");
			    	fileName = fileName.substring(fileName.lastIndexOf("/")+1);
			    	console.log(fileName);
			    	
			    	$.ajax({
			    		type: "POST",
			    		url: "../boardFile/summerDelete",
			    		data:{fileName,fileName},
			    		success:function(data){
			    			console.log(data.trim());
			    			
			    		}			    		
			    		
			    	});
		
			    	
			    	
			    }//onMediaDelete
			    
			    
			  }//callBack
		  });
    
	
	
	
	
	////////////////////////////////////////////////////////////////////////
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
	
	
	
	
	