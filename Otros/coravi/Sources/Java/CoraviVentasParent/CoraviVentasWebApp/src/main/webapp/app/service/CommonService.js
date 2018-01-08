'use strict';

angular.module('MyApp').factory('CommonService', ['$http', '$q', function($http, $q){

    var factory = {
        fetchAllModels: fetchAllModels,
        createModel: createModel,
        updateModel: updateModel,
        deleteModel: deleteModel
    };

    return factory;

    function fetchAllModels() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching Models');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function createModel(model) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI, model)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while creating Model');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }


    function updateModel(model, id) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI+id, model)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while updating Model');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function deleteModel(id) {
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI+id)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while deleting Model');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

}]);
