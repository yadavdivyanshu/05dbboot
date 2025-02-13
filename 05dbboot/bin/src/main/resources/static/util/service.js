sap.ui.define(["jquery.sap.global"], function(jQuery) {
	return {
		callService: function(sURL, sMethod, sPayload) {
			return new Promise(function(resolve, reject) {
				switch (sMethod.toUpperCase()) {
					case "GET":
						jQuery.ajax(sURL, {
							type: "GET",
							success: function(data) {
								resolve(data);
							},
							error: function(err) {
								reject(err);
							}
						});
						break;
					case "POST":
						jQuery.ajax(sURL, {
							type: "POST",
							contentType: "application/json",
							data: JSON.stringify(sPayload),
							success: function(data) {
								resolve(data);
							},
							error: function(err) {
								reject(err);
							}
						});
						break;
					case "DELETE":
						jQuery.ajax(sURL, {
							type: "DELETE",
							success: function(data) {
								resolve(data);
							},
							error: function(err) {
								reject(err);
							}
						});
						break;
				}
			});
		}
	}
});