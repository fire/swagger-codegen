extends HTTPRequest

# coding: utf-8

"""
    OpenAPI Petstore

    This is a sample server Petstore server. For this sample, you can use the api key `special-key` to test the authorization filters.

    OpenAPI spec version: 1.0.0
    
    Generated by: https://github.com/OpenAPITools/openapi-generator.git
"""


export(String) var private_key
export(String) var game_id
export(String) var base_url
export(bool) var ssl_validate_domain
export(bool) var validate

var username_cache
var token_cache
var request_type

var busy = false

preload("../Models/order.gd")
var unirest = preload("../unirest.gd")

"""Delete purchase order by ID

For valid response try integer IDs with value < 1000. Anything above 1000 or nonintegers will generate API errors
:param String order_id: ID of the order that needs to be deleted (required)
"""

func delete_order(String order_id,  auth = null, callback = null):   
    unirest.delete(base_url + "/store/order/{orderId}", {  }, {  }, auth, callback)

"""Returns pet inventories by status

Returns a map of status codes to quantities
"""

func get_inventory( auth = null, callback = null):   
    unirest.get(base_url + "/store/inventory", {  }, {  }, auth, callback)

"""Find purchase order by ID

For valid response try integer IDs with value <= 5 or > 10. Other values will generated exceptions
:param int order_id: ID of pet that needs to be fetched (required)
"""

func get_order_by_id(int order_id,  auth = null, callback = null):   
    unirest.get(base_url + "/store/order/{orderId}", {  }, {  }, auth, callback)

"""Place an order for a pet

:param Order body: order placed for purchasing the pet (required)
"""

func place_order(Order body,  auth = null, callback = null):   
    unirest.post(base_url + "/store/order", {  }, { JSON.print(body.dict) }, auth, callback)

