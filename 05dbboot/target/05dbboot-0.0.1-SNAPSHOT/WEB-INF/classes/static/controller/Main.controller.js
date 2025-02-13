sap.ui.define(["sap/ui/core/mvc/Controller",
	"anubhav/util/service",
	"sap/m/MessageBox"
], function(Controller, Service, MessageBox) {
	return Controller.extend("anubhav.controller.Main", {
		onInit: function() {
			var that = this;
			var oModel = new sap.ui.model.json.JSONModel();
			oModel.setData({
				"vendor": {},
				"payload": {
					"companyName": "",
					"firstName": "",
					"lastName": "",
					"website": "",
					"email": "",
					"status": "A",
					"gstNo": "",
				}
			});
			sap.ui.getCore().setModel(oModel);
			var oTable = this.byId("idTable");
			oTable.bindRows("/vendor");
		},
		onLoadData: function() {

			Service.callService("/vendor", "GET", {}).then(function(data) {
				sap.ui.getCore().getModel().setProperty("/vendor", data);
			}, function(error) {
				alert("There was some error in GET call", error);
			});
		},
		onSave: function() {
			Service.callService("/vendor", "POST", sap.ui.getCore().getModel().getProperty("/payload")).then(
				function(data) {
					MessageBox.success("Saved!");
				},
				function(err) {
					MessageBox.error("There was some error");
				}
			);
		},
		onDelete: function() {
			var oTable = this.byId("idTable");
			var selIndArr = oTable.getSelectedIndices();
			if (selIndArr.length == 0)
				MessageBox.error("Select a row please");
			else {
				var selInd = selIndArr[0];
				var oRow = oTable.getRows()[selInd];
				var delId = sap.ui.getCore().getModel().getProperty(oRow.getBindingContext().sPath).id;
				Service.callService("/vendor/" + delId, "DELETE", sap.ui.getCore().getModel().getProperty("/payload")).then(
					function(data) {
						MessageBox.success("Deleted!");
					},
					function(err) {
						MessageBox.error("There was some error");
					}
				);
			}
		}
	});
});