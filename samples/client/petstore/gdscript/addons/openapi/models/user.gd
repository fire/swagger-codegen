extends Reference
class_name User

var id
var username
var first_name
var last_name
var email
var password
var phone
var user_status

func get_array():
    return [ id, username, first_name, last_name, email, password, phone, user_status ]

func get_dict():
    return { "id": id, "username": username, "first_name": first_name, "last_name": last_name, "email": email, "password": password, "phone": phone, "user_status": user_status }
