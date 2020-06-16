 function goFirst() {
	$.ajax({
		type: 'get',
		url: '/product/Products?cmd=goFirst',
		dataType: 'json'
	}).done(function(list) {
	
		$("#product__list").empty();
		for(var product of list) {
			var string = 
				"<tr>\r\n" + 
				"			        <td>"+product.id+"</td>\r\n" + 
				"			        <td>"+product.name+"</td>\r\n" + 
				"			        <td>"+product.type+"</td>\r\n" + 
				"			        <td>"+product.price+"</td>\r\n" + 
				"			        <td>"+product.count+"</td>\r\n" + 
				"<td><i onclick=\"Delete("+product.id+")\" style=\"font-size: 30px; cursor: pointer;\" class=\"material-icons\">delete</i></td>"
				"			      </tr>";
		
			$("#product__list").append(string);
		}
	}).fail(function(list) {
		console.log(error);
	});
}

 function goPrice() {
		$.ajax({
			type: 'get',
			url: '/product/Products?cmd=goPrice',
			dataType: 'json'
		}).done(function(list) {
		
			$("#product__list").empty();
			for(var product of list) {
				var string = 
					"<tr>\r\n" + 
					"			        <td>"+product.id+"</td>\r\n" + 
					"			        <td>"+product.name+"</td>\r\n" + 
					"			        <td>"+product.type+"</td>\r\n" + 
					"			        <td>"+product.price+"</td>\r\n" + 
					"			        <td>"+product.count+"</td>\r\n" + 
					"<td><i onclick=\"Delete("+product.id+")\" style=\"font-size: 30px; cursor: pointer;\" class=\"material-icons\">delete</i></td>"
					"			      </tr>";
			
				$("#product__list").append(string);
			}
		}).fail(function(list) {
			console.log(error);
		});
	}
 
 function goCount() {
		$.ajax({
			type: 'get',
			url: '/product/Products?cmd=goCount',
			dataType: 'json'
		}).done(function(list) {
		
			$("#product__list").empty();
			for(var product of list) {
				var string = 
					"<tr>\r\n" + 
					"			        <td>"+product.id+"</td>\r\n" + 
					"			        <td>"+product.name+"</td>\r\n" + 
					"			        <td>"+product.type+"</td>\r\n" + 
					"			        <td>"+product.price+"</td>\r\n" + 
					"			        <td>"+product.count+"</td>\r\n" + 
					"<td><i onclick=\"Delete("+product.id+")\" style=\"font-size: 30px; cursor: pointer;\" class=\"material-icons\">delete</i></td>"
					"			      </tr>";
			
				$("#product__list").append(string);
			}
		}).fail(function(list) {
			console.log(error);
		});
	}
 
 function Delete(id) {
		$.ajax({
			type: 'get',
			url: '/product/Products?cmd=Delete',
			data: "id=" + id,
			contentType: "application/x-www-form-urlencoded; charset=utf-8",
			dataType: "text"
		}).done(function(result) {
			if(result == 1) {
				$("#product__"+id).remove();
				alert("삭제되었습니다.")
			} else {
				alert("삭제가 실패하였습니다.")
			}
		}).fail(function(list) {
			alert("삭제실패.")
			console.log(error);
		});
	}