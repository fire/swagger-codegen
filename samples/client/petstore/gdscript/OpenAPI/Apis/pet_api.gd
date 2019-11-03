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

preload("../Models/api_response.gd")
preload("../Models/pet.gd")
preload("../Models/file.gd")
var unirest = preload("../unirest.gd")

"""Add a new pet to the store

:param Pet body: Pet object that needs to be added to the store (required)
"""

func add_pet(Pet body,  auth = null, callback = null):   
    unirest.post(base_url + "/pet", {  }, { JSON.print(body.dict) }, auth, callback)

"""Deletes a pet

:param int pet_id: Pet id to delete (required)
:param String api_key:
"""

func delete_pet(int pet_id,  auth = null, callback = null):   
    unirest.delete(base_url + "/pet/{petId}", { api_key=api_key }, {  }, auth, callback)

"""Finds Pets by status

Multiple status values can be provided with comma separated strings
:param List[String] status: Status values that need to be considered for filter (required)
"""

func find_pets_by_status(List[String] status,  auth = null, callback = null):   
    unirest.get(base_url + "/pet/findByStatus", {  }, {  }, auth, callback)

"""Finds Pets by tags

Multiple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.
:param List[String] tags: Tags to filter by (required)
"""

func find_pets_by_tags(List[String] tags,  auth = null, callback = null):   
    unirest.get(base_url + "/pet/findByTags", {  }, {  }, auth, callback)

"""Find pet by ID

Returns a single pet
:param int pet_id: ID of pet to return (required)
"""

func get_pet_by_id(int pet_id,  auth = null, callback = null):   
    unirest.get(base_url + "/pet/{petId}", {  }, {  }, auth, callback)

"""Update an existing pet

:param Pet body: Pet object that needs to be added to the store (required)
"""

func update_pet(Pet body,  auth = null, callback = null):   
    unirest.put(base_url + "/pet", {  }, { JSON.print(body.dict) }, auth, callback)

"""Updates a pet in the store with form data

:param int pet_id: ID of pet that needs to be updated (required)
:param String name: Updated name of the pet
:param String status: Updated status of the pet
"""

func update_pet_with_form(int pet_id,  auth = null, callback = null):   
    unirest.post(base_url + "/pet/{petId}", {  }, {  }, auth, callback)

"""uploads an image

:param int pet_id: ID of pet to update (required)
:param String additional_metadata: Additional data to pass to server
:param file file: file to upload
"""

func upload_file(int pet_id,  auth = null, callback = null):   
    unirest.post(base_url + "/pet/{petId}/uploadImage", {  }, {  }, auth, callback)

