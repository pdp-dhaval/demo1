app.controller("studentRegistrationCtrl", function ($scope,$http) {
    $scope.student = {};
    $scope.student.gender = {};
    $scope.department = {};
    $scope.students = [];
    $scope.studentByDepartment = [];
    $scope.genders = [];
    $scope.courses = [];
    $scope.selectedCourses = [];
    $scope.departments = [];
    
    $scope.buttonText = "Add";
    $scope.isEditMode = false;
    var url = "localhost:9090/springbootexample/";
    
    
    $scope.addStudent = function(){
    	
    		$scope.selectedCourses = $scope.courses.filter(function (course) {
    		    if(course.selected){
    		    	return course.id;
    		    }
    		});
    		
    		$scope.student.courses = angular.copy($scope.selectedCourses);
    		
    	$http({
    		  method: 'POST',
    		  url: "add_student",
    		  data : JSON.stringify($scope.student),
    		  contentType:"application/json",
    		}).then(function successCallback(response) {
    			console.log("response==>",response);
    			$scope.student = {};
    			$scope.selectedCourses = [];
    			checkSelectedCourses();
    			$scope.buttonText = "Add";
    			$scope.getStudents();
    		    
    		  }, function errorCallback(error) {
    			  console.log("error==>",error);
    			  $scope.buttonText = "Add";
    			  $scope.student = {};

    		  });
}

$scope.getStudents = function(){
	$http({
		  method: 'GET',
		  url: "students"})
		  .then(function successCallback(response) {
			console.log("response==>",response);
			$scope.students = response.data;

		  }, function errorCallback(error) {
			  console.log("error==>",error);
		    
		  });
}

$scope.deleteStudent = function(student){
	$http({
		  method: 'DELETE',
		  url: "delete_student/" + student.id 
		  })
		  .then(function successCallback(response) {
			$scope.getStudents();
			
		  }, function errorCallback(error) {
			  console.log("error==>",error);
		  });
}


$scope.editStudent = function(student){
	$scope.student = angular.copy(student);
	$scope.isEditMode = true;
	$scope.buttonText = "Update";
	$scope.selectedCourses = angular.copy($scope.student.courses);
	checkSelectedCourses();
}

function checkSelectedCourses(){
	for(var i=0;i < $scope.courses.length;i++){
		$scope.courses[i].selected = false;
		for(var j=0; j< $scope.selectedCourses.length;j++){
			if($scope.selectedCourses[j].id == $scope.courses[i].id){
				$scope.courses[i].selected = true;
			}
		}
	}
}

$scope.cancelEdit = function(){
	$scope.isEditMode = false;
	$scope.student = {};
	$scope.buttonText = "Add";
	$scope.selectedCourses = [];
	checkSelectedCourses();
}


$scope.getDepartments = function(){
	$http({
		  method: 'GET',
		  url: "departments"})
		  .then(function successCallback(response) {
			console.log("response==>",response);
			$scope.departments = response.data;
		  }, function errorCallback(error) {
			  console.log("error==>",error);
		  });
}

$scope.getStudentsByDepartment = function(deptId){
	$http({
		  method: 'GET',
		  url: "students_by_department/" + deptId
		})
		  .then(function successCallback(response) {
			console.log("department by students==>",response);
			$scope.studentByDepartment = response.data;
		  }, function errorCallback(error) {
			  console.log("error==>",error);
		  });
}

$scope.getGenders = function(){
	$http({
		  method: 'GET',
		  url: "genders"
		})
		  .then(function successCallback(response) {
			console.log("genders==>",response);
			$scope.genders = response.data;
		    // this callback will be called asynchronously
		    // when the response is available
		  }, function errorCallback(error) {
			  console.log("error==>",error);
		    // called asynchronously if an error occurs
		    // or server returns response with an error status.
		  });
}

$scope.getCourses = function(){
	$http({
		  method: 'GET',
		  url: "courses"
		})
		  .then(function successCallback(response) {
			console.log("Courses==>",response);
			$scope.courses = response.data;
		  }, function errorCallback(error) {
			  console.log("error==>",error);
		  });
}


$scope.studentByName = {};

$scope.getStudentById = function(studId){
	$http({
		  method: 'GET',
		  url: "student/" + studId
		})
		  .then(function successCallback(response) {
			console.log("students by name==>",response);
			$scope.studentByName = response.data;
		  }, function errorCallback(error) {
			  console.log("error==>",error);
		  });
}


  
$scope.getCourses();
$scope.getStudents();
$scope.getGenders();
$scope.getDepartments();
});