# openapi.StoreApi

All URIs are relative to *http://petstore.swagger.io/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**delete_order**](StoreApi.md#delete_order) | **DELETE** /store/order/{orderId} | Delete purchase order by ID
[**get_inventory**](StoreApi.md#get_inventory) | **GET** /store/inventory | Returns pet inventories by status
[**get_order_by_id**](StoreApi.md#get_order_by_id) | **GET** /store/order/{orderId} | Find purchase order by ID
[**place_order**](StoreApi.md#place_order) | **POST** /store/order | Place an order for a pet


# **delete_order**
> delete_order(order_id)

Delete purchase order by ID

For valid response try integer IDs with value < 1000. Anything above 1000 or nonintegers will generate API errors

### Example
```gdscript
extends Node2D

var store_api = load("res://addons/openapi/apis/store_api.gd")

func _ready():
	var store_api = store_api.new()
	store_api.name = "store_api"
	add_child(store_api)	
	store_api.connect("api_delete_order", self, "api_delete_order")
	store_api.base_url = "http://petstore.swagger.io/v2"
	store_api.delete_order(order_id)
	
func api_delete_order(result):
	print(result)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **order_id** | **String**| ID of the order that needs to be deleted | 

### Return type

void (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_inventory**
> Dictionary(str, int) get_inventory()

Returns pet inventories by status

Returns a map of status codes to quantities

### Example
```gdscript
extends Node2D

var store_api = load("res://addons/openapi/apis/store_api.gd")

func _ready():
	var store_api = store_api.new()
	store_api.name = "store_api"
	add_child(store_api)	
	store_api.connect("api_get_inventory", self, "api_get_inventory")
	store_api.base_url = "http://petstore.swagger.io/v2"
	store_api.get_inventory()
	
func api_get_inventory(result):
	print(result)
```

### Parameters
This endpoint does not need any parameter.

### Return type

**Dictionary(str, int)**

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_order_by_id**
> Order get_order_by_id(order_id)

Find purchase order by ID

For valid response try integer IDs with value <= 5 or > 10. Other values will generated exceptions

### Example
```gdscript
extends Node2D

var store_api = load("res://addons/openapi/apis/store_api.gd")

func _ready():
	var store_api = store_api.new()
	store_api.name = "store_api"
	add_child(store_api)	
	store_api.connect("api_get_order_by_id", self, "api_get_order_by_id")
	store_api.base_url = "http://petstore.swagger.io/v2"
	store_api.get_order_by_id(order_id)
	
func api_get_order_by_id(result):
	print(result)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **order_id** | **int**| ID of pet that needs to be fetched | 

### Return type

[**Order**](Order.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/xml, application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **place_order**
> Order place_order(body)

Place an order for a pet

### Example
```gdscript
extends Node2D

var store_api = load("res://addons/openapi/apis/store_api.gd")

func _ready():
	var store_api = store_api.new()
	store_api.name = "store_api"
	add_child(store_api)	
	store_api.connect("api_place_order", self, "api_place_order")
	store_api.base_url = "http://petstore.swagger.io/v2"
	store_api.place_order(body)
	
func api_place_order(result):
	print(result)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**Order**](Order.md)| order placed for purchasing the pet | 

### Return type

[**Order**](Order.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/xml, application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

