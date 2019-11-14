# openapi.UserApi

All URIs are relative to *http://petstore.swagger.io/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**create_user**](UserApi.md#create_user) | **POST** /user | Create user
[**create_users_with_array_input**](UserApi.md#create_users_with_array_input) | **POST** /user/createWithArray | Creates list of users with given input array
[**create_users_with_list_input**](UserApi.md#create_users_with_list_input) | **POST** /user/createWithList | Creates list of users with given input array
[**delete_user**](UserApi.md#delete_user) | **DELETE** /user/{username} | Delete user
[**get_user_by_name**](UserApi.md#get_user_by_name) | **GET** /user/{username} | Get user by user name
[**login_user**](UserApi.md#login_user) | **GET** /user/login | Logs user into the system
[**logout_user**](UserApi.md#logout_user) | **GET** /user/logout | Logs out current logged in user session
[**update_user**](UserApi.md#update_user) | **PUT** /user/{username} | Updated user


# **create_user**
> create_user(body)

Create user

This can only be done by the logged in user.

### Example
```gdscript
extends Node2D

var user_api = load("res://addons/openapi/apis/user_api.gd")

func _ready():
	var user_api = user_api.new()
	user_api.name = "user_api"
	add_child(user_api)	
	user_api.connect("api_create_user", self, "api_create_user")
	user_api.base_url = "http://petstore.swagger.io/v2"
	user_api.create_user(body)
	
func api_create_user(result):
	print(result)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**User**](User.md)| Created user object | 

### Return type

void (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **create_users_with_array_input**
> create_users_with_array_input(body)

Creates list of users with given input array

### Example
```gdscript
extends Node2D

var user_api = load("res://addons/openapi/apis/user_api.gd")

func _ready():
	var user_api = user_api.new()
	user_api.name = "user_api"
	add_child(user_api)	
	user_api.connect("api_create_users_with_array_input", self, "api_create_users_with_array_input")
	user_api.base_url = "http://petstore.swagger.io/v2"
	user_api.create_users_with_array_input(body)
	
func api_create_users_with_array_input(result):
	print(result)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**Array**](User.md)| List of user object | 

### Return type

void (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **create_users_with_list_input**
> create_users_with_list_input(body)

Creates list of users with given input array

### Example
```gdscript
extends Node2D

var user_api = load("res://addons/openapi/apis/user_api.gd")

func _ready():
	var user_api = user_api.new()
	user_api.name = "user_api"
	add_child(user_api)	
	user_api.connect("api_create_users_with_list_input", self, "api_create_users_with_list_input")
	user_api.base_url = "http://petstore.swagger.io/v2"
	user_api.create_users_with_list_input(body)
	
func api_create_users_with_list_input(result):
	print(result)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**Array**](User.md)| List of user object | 

### Return type

void (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **delete_user**
> delete_user(username)

Delete user

This can only be done by the logged in user.

### Example
```gdscript
extends Node2D

var user_api = load("res://addons/openapi/apis/user_api.gd")

func _ready():
	var user_api = user_api.new()
	user_api.name = "user_api"
	add_child(user_api)	
	user_api.connect("api_delete_user", self, "api_delete_user")
	user_api.base_url = "http://petstore.swagger.io/v2"
	user_api.delete_user(username)
	
func api_delete_user(result):
	print(result)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **username** | **String**| The name that needs to be deleted | 

### Return type

void (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_user_by_name**
> User get_user_by_name(username)

Get user by user name

### Example
```gdscript
extends Node2D

var user_api = load("res://addons/openapi/apis/user_api.gd")

func _ready():
	var user_api = user_api.new()
	user_api.name = "user_api"
	add_child(user_api)	
	user_api.connect("api_get_user_by_name", self, "api_get_user_by_name")
	user_api.base_url = "http://petstore.swagger.io/v2"
	user_api.get_user_by_name(username)
	
func api_get_user_by_name(result):
	print(result)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **username** | **String**| The name that needs to be fetched. Use user1 for testing. | 

### Return type

[**User**](User.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/xml, application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **login_user**
> String login_user(username, password)

Logs user into the system

### Example
```gdscript
extends Node2D

var user_api = load("res://addons/openapi/apis/user_api.gd")

func _ready():
	var user_api = user_api.new()
	user_api.name = "user_api"
	add_child(user_api)	
	user_api.connect("api_login_user", self, "api_login_user")
	user_api.base_url = "http://petstore.swagger.io/v2"
	user_api.login_user(username, password)
	
func api_login_user(result):
	print(result)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **username** | **String**| The user name for login | 
 **password** | **String**| The password for login in clear text | 

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/xml, application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **logout_user**
> logout_user()

Logs out current logged in user session

### Example
```gdscript
extends Node2D

var user_api = load("res://addons/openapi/apis/user_api.gd")

func _ready():
	var user_api = user_api.new()
	user_api.name = "user_api"
	add_child(user_api)	
	user_api.connect("api_logout_user", self, "api_logout_user")
	user_api.base_url = "http://petstore.swagger.io/v2"
	user_api.logout_user()
	
func api_logout_user(result):
	print(result)
```

### Parameters
This endpoint does not need any parameter.

### Return type

void (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **update_user**
> update_user(username, body)

Updated user

This can only be done by the logged in user.

### Example
```gdscript
extends Node2D

var user_api = load("res://addons/openapi/apis/user_api.gd")

func _ready():
	var user_api = user_api.new()
	user_api.name = "user_api"
	add_child(user_api)	
	user_api.connect("api_update_user", self, "api_update_user")
	user_api.base_url = "http://petstore.swagger.io/v2"
	user_api.update_user(username, body)
	
func api_update_user(result):
	print(result)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **username** | **String**| name that need to be deleted | 
 **body** | [**User**](User.md)| Updated user object | 

### Return type

void (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

