 function goName(name) {
	$.ajax({
		type: 'get',
		url: '/vollyball/home?cmd=goName&name='+name,
		dataType: 'json'
	}).done(function(names) {
	
		$("#vollyball__name").empty();
		for(var vollyball of names) {
			var string = 
				"<tr>\r\n" + 
				"			        <td>"+vollyball.name+"</td>\r\n" + 
				"			      </tr>";
		
			$("#vollyball__name").append(string);
		}
	}).fail(function(names) {
		console.log(error);
	});
}
 
 function goDetail(name, team) {
		$.ajax({
			type: 'get',
			url: '/vollyball/home?cmd=goDetail&name='+name +'team='+team,
			dataType: 'json'
		}).done(function(details) {
		
			$("#vollyball__detail").empty();
			for(var vollyball of details) {
				var string = 
					"<tr>\r\n" + 
					"			        <td>"+vollyball.id+"</td>\r\n" + 
					"			        <td>"+vollyball.name+"</td>\r\n" + 
					"			        <td>"+vollyball.position+"</td>\r\n" + 
					"			      </tr>";
			
				$("#vollyball__detail").append(string);
			}
		}).fail(function(details) {
			console.log(error);
		});
	}
