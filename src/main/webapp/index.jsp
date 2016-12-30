<!DOCTYPE html>
<html>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/angular.min.js"></script>
<script src = "js/myUsers.js"></script>
<body ng-app="myApp" ng-controller="userCtrl">

<div class="container">

    <h3>Users</h3>

    <table class="table table-striped">
        <thead>
            <tr>
            <th>Edit</th>
            <th>First Name</th>
            <th>Last Name</th>
            </tr>
        </thead>
        <tbody>
            <tr ng-repeat="user in users">
                <td>
                    <button class="btn" ng-click="editUser(user.id)">
                        <span class="glyphicon glyphicon-pencil"></span>&nbsp;&nbsp;Edit
                    </button>
                </td>
                <td>{{ user.fName }}</td>
                <td>{{ user.lName }}</td>
            </tr>
        </tbody>
    </table>

    <hr>
    <button class="btn btn-success" ng-click="editUser('new')">
        <span class="glyphicon glyphicon-user"></span>Create New User
    </button>
    <hr>

    <h3 ng-show="edit">Create New User:</h3>
    <h3 ng-hide="edit">Edit User:</h3>

    <form class="form-horizontal">
        <div class="form-group">
            <label class="col-sm-2 control-label">First Name:</label>
            <div class="col-sm-10">
                <input type="text" ng-model="fName" ng-disabled="!edit" placeholder="First Name">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">Last Name:</label>
            <div class="col-sm-10">
                <input type="text" ng-model="lName" ng-disabled="!edit" placeholder="Last Name">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">Password:</label>
            <div class="col-sm-10">
                <input type="password" ng-model="passw1" placeholder="Password">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">Repeat:</label>
            <div class="col-sm-10">
                <input type="password" ng-model="passw2" placeholder="Repeat Password">
            </div>
        </div>
    </form>

    <hr>
    <button class="btn btn-success" ng-disabled="error || incomplete">
        <span class="glyphicon glyphicon-save"></span> Save Changes
    </button>
</div>
</body>
</html>