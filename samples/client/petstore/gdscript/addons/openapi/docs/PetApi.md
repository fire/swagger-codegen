# openapi.PetApi

All URIs are relative to *http://petstore.swagger.io/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**add_pet**](PetApi.md#add_pet) | **POST** /pet | Add a new pet to the store
[**delete_pet**](PetApi.md#delete_pet) | **DELETE** /pet/{petId} | Deletes a pet
[**find_pets_by_status**](PetApi.md#find_pets_by_status) | **GET** /pet/findByStatus | Finds Pets by status
[**find_pets_by_tags**](PetApi.md#find_pets_by_tags) | **GET** /pet/findByTags | Finds Pets by tags
[**get_pet_by_id**](PetApi.md#get_pet_by_id) | **GET** /pet/{petId} | Find pet by ID
[**update_pet**](PetApi.md#update_pet) | **PUT** /pet | Update an existing pet
[**update_pet_with_form**](PetApi.md#update_pet_with_form) | **POST** /pet/{petId} | Updates a pet in the store with form data
[**upload_file**](PetApi.md#upload_file) | **POST** /pet/{petId}/uploadImage | uploads an image


# **add_pet**
> add_pet(body)

Add a new pet to the store

### Example
```gdscript
extends Node2D

var pet_api = load("res://addons/openapi/apis/pet_api.gd")

func _ready():
	var pet_api = pet_api.new()
	res.name = "pet_api"
	add_child(res)	
	res.connect("api_add_pet", self, "api_add_pet")
	res.base_url = "http://petstore.swagger.io/v2"
	res.add_pet(body)
	
func api_add_pet(result):
	print(result)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**Pet**](Pet.md)| Pet object that needs to be added to the store | 

### Return type

void (empty response body)

### Authorization

[petstore_auth](../README.md#petstore_auth)

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: Not defined

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **delete_pet**
> delete_pet(pet_id, api_key=api_key)

Deletes a pet

### Example
```gdscript
extends Node2D

var pet_api = load("res://addons/openapi/apis/pet_api.gd")

func _ready():
	var pet_api = pet_api.new()
	res.name = "pet_api"
	add_child(res)	
	res.connect("api_delete_pet", self, "api_delete_pet")
	res.base_url = "http://petstore.swagger.io/v2"
	res.delete_pet(pet_id, api_key=api_key)
	
func api_delete_pet(result):
	print(result)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **pet_id** | **int**| Pet id to delete | 
 **api_key** | **String**|  | [optional] 

### Return type

void (empty response body)

### Authorization

[petstore_auth](../README.md#petstore_auth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **find_pets_by_status**
> Array find_pets_by_status(status)

Finds Pets by status

Multiple status values can be provided with comma separated strings

### Example
```gdscript
extends Node2D

var pet_api = load("res://addons/openapi/apis/pet_api.gd")

func _ready():
	var pet_api = pet_api.new()
	res.name = "pet_api"
	add_child(res)	
	res.connect("api_find_pets_by_status", self, "api_find_pets_by_status")
	res.base_url = "http://petstore.swagger.io/v2"
	res.find_pets_by_status(status)
	
func api_find_pets_by_status(result):
	print(result)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **status** | [**PoolStringArray**](String.md)| Status values that need to be considered for filter | 

### Return type

[**Array**](Pet.md)

### Authorization

[petstore_auth](../README.md#petstore_auth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/xml, application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **find_pets_by_tags**
> Array find_pets_by_tags(tags)

Finds Pets by tags

Multiple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.

### Example
```gdscript
extends Node2D

var pet_api = load("res://addons/openapi/apis/pet_api.gd")

func _ready():
	var pet_api = pet_api.new()
	res.name = "pet_api"
	add_child(res)	
	res.connect("api_find_pets_by_tags", self, "api_find_pets_by_tags")
	res.base_url = "http://petstore.swagger.io/v2"
	res.find_pets_by_tags(tags)
	
func api_find_pets_by_tags(result):
	print(result)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tags** | [**PoolStringArray**](String.md)| Tags to filter by | 

### Return type

[**Array**](Pet.md)

### Authorization

[petstore_auth](../README.md#petstore_auth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/xml, application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_pet_by_id**
> Pet get_pet_by_id(pet_id)

Find pet by ID

Returns a single pet

### Example
```gdscript
extends Node2D

var pet_api = load("res://addons/openapi/apis/pet_api.gd")

func _ready():
	var pet_api = pet_api.new()
	res.name = "pet_api"
	add_child(res)	
	res.connect("api_get_pet_by_id", self, "api_get_pet_by_id")
	res.base_url = "http://petstore.swagger.io/v2"
	res.get_pet_by_id(pet_id)
	
func api_get_pet_by_id(result):
	print(result)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **pet_id** | **int**| ID of pet to return | 

### Return type

[**Pet**](Pet.md)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/xml, application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **update_pet**
> update_pet(body)

Update an existing pet

### Example
```gdscript
extends Node2D

var pet_api = load("res://addons/openapi/apis/pet_api.gd")

func _ready():
	var pet_api = pet_api.new()
	res.name = "pet_api"
	add_child(res)	
	res.connect("api_update_pet", self, "api_update_pet")
	res.base_url = "http://petstore.swagger.io/v2"
	res.update_pet(body)
	
func api_update_pet(result):
	print(result)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**Pet**](Pet.md)| Pet object that needs to be added to the store | 

### Return type

void (empty response body)

### Authorization

[petstore_auth](../README.md#petstore_auth)

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: Not defined

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **update_pet_with_form**
> update_pet_with_form(pet_id, name=name, status=status)

Updates a pet in the store with form data

### Example
```gdscript
extends Node2D

var pet_api = load("res://addons/openapi/apis/pet_api.gd")

func _ready():
	var pet_api = pet_api.new()
	res.name = "pet_api"
	add_child(res)	
	res.connect("api_update_pet_with_form", self, "api_update_pet_with_form")
	res.base_url = "http://petstore.swagger.io/v2"
	res.update_pet_with_form(pet_id, name=name, status=status)
	
func api_update_pet_with_form(result):
	print(result)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **pet_id** | **int**| ID of pet that needs to be updated | 
 **name** | **String**| Updated name of the pet | [optional] 
 **status** | **String**| Updated status of the pet | [optional] 

### Return type

void (empty response body)

### Authorization

[petstore_auth](../README.md#petstore_auth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: Not defined

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **upload_file**
> ApiResponse upload_file(pet_id, additional_metadata=additional_metadata, file=file)

uploads an image

### Example
```gdscript
extends Node2D

var pet_api = load("res://addons/openapi/apis/pet_api.gd")

func _ready():
	var pet_api = pet_api.new()
	res.name = "pet_api"
	add_child(res)	
	res.connect("api_upload_file", self, "api_upload_file")
	res.base_url = "http://petstore.swagger.io/v2"
	res.upload_file(pet_id, additional_metadata=additional_metadata, file=file)
	
func api_upload_file(result):
	print(result)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **pet_id** | **int**| ID of pet to update | 
 **additional_metadata** | **String**| Additional data to pass to server | [optional] 
 **file** | **PoolByteArray**| file to upload | [optional] 

### Return type

[**ApiResponse**](ApiResponse.md)

### Authorization

[petstore_auth](../README.md#petstore_auth)

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

