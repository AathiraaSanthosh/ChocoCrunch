$(function() {

	switch (menu) {

	case 'About Us':
		$('#about').addClass('active');
		break;

	case 'Contact Us':
		$('#contact').addClass('active');
		break;

	case 'All Products':
		$('#listProducts').addClass('active');
		break;

	case 'Manage Products':
		$('#manageProducts').addClass('active');
		break;

	case 'User Cart':
		$('#userCart').addClass('active');
		break;

	default:
		if (menu == "Home")
			break;
		$('#listProducts').addClass('active');
		$('#a_' + menu).addClass('active');
		break;
	}

	var $table = $('#productListTable');

	if ($table.length) {

		var jsonUrl = ' ';
  		if (window.categoryId == '') {

			jsonUrl = window.contextRoot + '/json/data/all/products';
		} else {

			jsonUrl = window.contextRoot + '/json/data/category/'
					+ window.categoryId + '/products';
		}

		$table
				.DataTable({

					lengthMenu : [ [ 1, 3, 5, -1 ],
							[ '1 records', '3 records', '5 records', 'ALL' ] ],
					pageLength : 5,
					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					columns : [
							{
								data : 'code',
								bSortable : false,
								mRender : function(data, type, row) {

									return '<img src ="'
											+ window.contextRoot
											+ '/resources/images/'
											+ data
											+ '.jpg" style="width:100px;height:100px"/>'
								}
							},
							{
								data : 'name'
							},
							{
								data : 'brand'
							},
							{
								data : 'unitPrice',
								mRender : function(data, type, row) {

									return '&#8377; ' + data;
								}
							},
							{
								data : 'quantity',
								mRender : function(data, type, row) {

									if (data < 1) {

										return '<span style="color:red">Out of Stock</span>';
									}
									return data;
								}
							},
							{
								data : 'id',
								bSortable : false,
								mRender : function(data, type, row) {

									var str = ' ';
									str += '<a href="'
											+ window.contextRoot
											+ '/show/'
											+ data
											+ '/product" class="btn btn-primary" ></a>';

									if (userRole == 'ADMIN') {

										str += '<a href="'
												+ window.contextRoot
												+ '/manage/'
												+ data
												+ '/product" class="btn btn-warning"></a>';
									} else { 

										if (row.quantity < 1) {
											str += '<ga href = "javascript:void(0)" class="glyphicon glyphicon-shopping-cart"></a>';
										} else {

											str += '<a href="'
													+ window.contextRoot
													+ '/cart/add/'
													+ data
													+ '/product" class="btn btn-success"></a>';
										}
									}
									return str;
								}

							} ]

				});
	}

	// dismissing the alert after 3 seconds

	var $alert = $('.alert');

	if ($alert.length) {
		setTimeout(function() {
			$alert.fadeOut('slow');
		}, 3000)
	}

	// -------------------------

	$('.switch input[type="checkbox"]')
			.on(
					'change',
					function() {

						var checkbox = $(this);
						var checked = checkbox.prop('checked');
						var dMsg = (checked) ? 'you want to activate the product?'
								: 'You want to deactivate the product';
						var value = checkbox.prop('value');

						bootbox
								.confirm({
									size : 'medium',
									title : 'Product Activation & Deactivation',
									message : dMsg,
									callback : function(confirmed) {
										if (confirmed) {

											console.log(value);
											bootbox
													.alert({
														size : 'medium',
														title : 'Information',
														message : 'You are going to perform operation on product'
																+ value
													});
										} else {
											checkbox.prop('checked', !checked);
										}
									}
								});
					});

	// -------------------------------
	// data table for admin
	// -------------------------

	var $adminProductsTable = $('#adminProductsTable');

	// execute the below code only where we have this table

	if ($adminProductsTable.length) {
		// console.log('Inside the table');

		var jsonUrl = window.contextRoot + '/json/data/admin/all/products';

		$adminProductsTable
				.DataTable({

					lengthMenu : [
							[ 10, 30, 50, -1 ],
							[ '10 Records', '30 Records', '50 Records',
									'All Records' ] ],
					pageLength : 30,
					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					columns : [
							{
								data : 'id'
							},
							{
								data : 'code',
								mRender : function(data, type, row) {
									return '<img src="'
											+ window.contextRoot
											+ '/resources/images/'
											+ data
											+ '.jpg" class="adminDataTableImg"/>';
								}
							},
							{
								data : 'name'

							},
							{
								data : 'brand'
							},

							{
								data : 'quantity',
								mRender : function(data, type, row) {

									if (data < 1) {
										return '<span style="color:red">Out Of Stock!</span>';
									}
									return data;
								}
							},
							{
								data : 'unitPrice',
								mRender : function(data, type, row) {
									return '&#8377; ' + data
								}
							},
							{
								data : 'active',
								bSortable : false,
								mRender : function(data, type, row) {
									var str = '';

									str += '<label class="switch">';
									if (data) {
										str += '<input type="checkbox" checked="checked" value="'
												+ row.id + '" />';
									} else {
										str += '<input type="checkbox" value="'
												+ row.id + '" />';
									}

									str += '<div class="slider round"></div></label>';

									return str;

								}

							},
							{

								data : 'id',
								bSortable : false,
								mRender : function(data, type, row) {

									var str = '';

									str += '<a href="'
											+ window.contextRoot
											+ '/manage/'
											+ data
											+ '/product" class="btn btn-warning">';
									str += '<span class="glyphicon glyphicon-pencil"></span></a>';

									return str;
								}
							}

					],

					initComplete : function() {

						var api = this.api();
						api
								.$('.switch input[type="checkbox"]')
								.on(
										'change',
										function() {

											var checkbox = $(this);
											var checked = checkbox
													.prop('checked');
											var dMsg = (checked) ? 'you want to activate the product?'
													: 'You want to deactivate the product';
											var value = checkbox.prop('value');

											bootbox
													.confirm({
														size : 'medium',
														title : 'Product Activation & Deactivation',
														message : dMsg,
														callback : function(
																confirmed) {
															if (confirmed) {

																console
																		.log(value);

																var activationUrl = window.contextRoot
																		+ '/manage/product/'
																		+ value
																		+ '/activation';

																$
																		.post(
																				activationUrl,
																				function(
																						data) {
																					bootbox
																							.alert({
																								size : 'medium',
																								title : 'Information',
																								message : data

																							});

																				});
															} else {
																checkbox
																		.prop(
																				'checked',
																				!checked);
															}
														}
													});
										});
					}

				});

	}

	// --------------------------
	// validation code for category

	var $loginForm = $('#loginForm');

	if ($loginForm.length) {

		$loginForm.validate({

			rules : {

				username : {

					required : true,
					email : 2

				},

				password : {

					required : true

				}

			},

			messages : {

				username : {

					required : 'Please Enter the user name!',
					minlength : 'Please enter the valid email address ! '
				},

				description : {

					required : 'Please enter the password!'

				}

			},
			errorElement : 'em',
			errorPlacement : function(error, element) {
				// add the class of help-block
				error.addClass('help-block');
				// add the error element after the input element
				error.insertAfter(element);
			}
		});

	}

	// -----------------

	// --------------------------
	// validation code for category

	var $categoryForm = $('#categoryForm')

	if ($categoryForm.length) {
		$categoryForm
				.validate({

					rules : {

						name : {

							required : true,
							minlength : 2
						},

						description : {
							required : true
						}
					},

					messages : {
						name : {
							required : 'Please add the category name!',
							minlength : 'The category name should not be less than 2 characters'
						},

						description : {
							required : 'Please add a description for this category!'
						}
					},
					errorElement : 'em',
					errorPlacement : function(error, element) {

						// add the class of help-block
						error.addClass('help-block');
						// add the error element after the input element
						error.insertAfter(element);
					}
				});
	}

	// -----------------
	// handling the click event of refresh cart button

	$('button[name="refreshCart"]')
			.click(
					function() {

						// fetch the cart line id
						var cartLineId = $(this).attr('value');
						var countElement = $('#count_' + cartLineId);

						var originalCount = countElement.attr('value');

						var currentCount = countElement.val();

						// work only when the count has changed

						if (currentCount !== originalCount) {

							if (currentCount < 1 || currentCount > 5) {
								// reverting back to the original count
								// user has given value below 1 and above 5

								countElement.val(originalCount);
								bootbox
										.alert({
											size : 'medium',
											title : 'Error',
											message : 'Product count should be minimum 1 and maximum 5!'
										});
							}

							else {

								var updateUrl = window.contextRoot + '/cart/'
										+ cartLineId + '/update?count='
										+ currentCount;
								// forward if to the controller

								window.location.href = updateUrl;
							}
						}

					});

	// -------------------------

});