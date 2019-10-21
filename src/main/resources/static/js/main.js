/**
 * 
 */

$(document).ready(function(){
  console.log('working');
  
  // Edit Modal
  $(".editButton").on("click",function(event){
	  event.preventDefault();
	  
	  var href = $(this).attr("href");
	  $.get(href,function(nationality,status) {
		  $("#IdEdit").val(nationality.id);
		  $("#nameEdit").val(nationality.name);
		  $("#capitalEdit").val(nationality.capital);
		  $("#updatedByEdit").val(nationality.updatedBy);
		  $("#updatedOnEdit").val(nationality.updatedOn.substr(0,10));
	  })	  
	  $("#editModal").modal();
  });

  // Stop Modal
  $(".stopButton").on("click",function(event){
	  event.preventDefault();
	  
	  var href = $(this).attr("href");
	  $.get(href,function(nationality,status) {
		  $("#IdDelete").val(nationality.id);
		  $("#nameDelete").val(nationality.name);
		  $("#capitalDelete").val(nationality.capital);
		  $("#updatedByDelete").val(nationality.updatedBy);
		  $("#updatedOnDelete").val(nationality.updatedOn);
	  })	  
	  $("#deleteModal").modal();
  });
  
  
  
});