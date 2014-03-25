angular.module('iteach.view.school', [
        'iteach.service.teacher'
    ])
    .controller('SchoolCtrl', function ($scope, $routeParams, teacherService) {

        var schoolId = $routeParams.schoolId;

        function loadSchool() {
            teacherService.getSchool(schoolId).success(function (school) {
                $scope.school = school;
            })
        }

        // Loads the school
        loadSchool();

        // Updating the school
        $scope.update = function () {
            teacherService.updateSchool($scope.school).then(loadSchool)
        };

        // Deleting the school
        $scope.delete = function () {
            teacherService.deleteSchool(schoolId)
        };

    })
;