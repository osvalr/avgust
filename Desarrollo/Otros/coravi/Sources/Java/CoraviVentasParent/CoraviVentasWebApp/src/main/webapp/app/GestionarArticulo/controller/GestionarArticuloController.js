'use strict';

var REST_SERVICE_URI = REST_SERVICE_URI + '/GestionarArticulo/';

angular.module('MyApp').controller('GestionarArticuloController', ['$scope', 'CommonService', function($scope, CommonService) {

    var self = this;

    self.model = emptyModel();
    
    self.response={};

    self.submit = submit;
    self.edit = edit;
    self.remove = remove;
    self.reset = reset;


    fetchAllModels();

    function emptyModel(){
       return {
            "id_articulo": null,
            "codigo_articulo": null,
            "nombre_articulo": null,
            "id_estado": null,
            "descrip_estado": null,
            "fecha_registro": null,
            "id_usuario_reg": null,
            "id_usuario_mod": null,
            "fecha_modificacion": null,
        };
    }

    function fetchAllModels(){
        CommonService.fetchAllModels()
            .then(
                function(d) {
                    self.response = d;
                },
                function(errResponse){
                    console.error('Error while fetching Models');
                }
            );
    }

    function createModel(model){
        CommonService.createModel(model)
            .then(
                fetchAllModels,
                function(errResponse){
                    console.error('Error while creating Model');
                }
            );
    }

    function updateModel(model, id){
        CommonService.updateModel(model, id)
            .then(
                fetchAllModels,
                function(errResponse){
                    console.error('Error while updating Model');
                }
            );
    }

    function deleteModel(id){
        CommonService.deleteModel(id)
            .then(
                fetchAllModels,
                function(errResponse){
                    console.error('Error while deleting Model');
                }
            );
    }

    function submit() {
        if(self.model.id===null){
            console.log('Saving New Model', self.model);
            createModel(self.model);
        }else{
            updateModel(self.model, self.model.id);
            console.log('Model updated with id ', self.model.id);
        }
        reset();
    }

    function edit(id){
        console.log('id to be edited', id);
        for(var i = 0; i < self.response.length; i++){
            if(self.response[i].id === id) {
                self.model = angular.copy(self.response[i]);
                break;
            }
        }
    }

    function remove(id){
        console.log('id to be deleted', id);
        if(self.model.id === id) {//clean form if the model to be deleted is shown there.
            reset();
        }
        deleteModel(id);
    }


    function reset(){
        self.model=emptyModel();
        $scope.myForm.$setPristine(); //reset Form
    }

}]);
