angular.module('patrulha', []).controller('patrulha', function ($scope, $http, $location) {
	var uri = '/api/v1/patrulha';
	$http.get('/user/').then(function (response) {
		$scope.user = response.data.name;
	});
	$http.get(uri).then(function (response) {
		$scope.itens = response.data;
	});
	
	$scope.add = function (isValid) {
		if (isValid) {
			var patrulha = {
				'nome': $scope.nomePatrulha
			};

			console.log(patrulha);

			var res = $http.post(uri, patrulha);
			res.success(function (data, status, headers, config) {
				$scope.itens.push(data);
				$scope.nomePatrulha = "";
				$location.path( "/" );
			});
			res.error(function (data, status, headers, config) {
				self.error = true;
				self.errorMessage = "Falha ao salvar a Patrulha: " + data.error
					+ "(" + data.message + ")";
			});
		};
	};
	
	$scope.edit = function (item) {
		
	};
	
	$scope.saveEdit = function (isValid) {
		
	};

	$scope.delete = function (item, index) {
		var res = $http.delete(uri +'/' + item.id);
		res.success(function (data, status, headers, config) {
			$scope.itens.splice(index, 1);
		});
		res.error(function (data, status, headers, config) {
			self.error = true;
			self.errorMessage = "Falha ao apagar a Patrulha: "
				+ data.error
				+ "(" + data.message + ")";
		});
	};

});
