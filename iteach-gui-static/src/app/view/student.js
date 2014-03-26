angular.module('iteach.view.student', [
        'iteach.service.teacher'
    ])
    .controller('StudentCtrl', function ($scope, $routeParams, teacherService) {

        var studentId = $routeParams.studentId;

        function loadStudent() {
            teacherService.getStudent(studentId).success(function (student) {
                $scope.student = student;
            })
        }

        // Loads the school
        loadStudent();

        // Updating the student
        $scope.update = function () {
            teacherService.updateStudent($scope.student).then(loadStudent);
        };

        // Deleting the student
        $scope.delete = function () {
            teacherService.deleteStudent(studentId);
        };

        // Disabling the student
        $scope.disable = function () {
            teacherService.disableStudent(studentId).then(loadStudent);
        };

        // Enabling the student
        $scope.enable = function () {
            teacherService.enableStudent(studentId).then(loadStudent);
        };

    })
;