extends Reference
class_name ApiResponse

var code
var type
var message

func get_array():
    return [ code, type, message ]

func get_dict():
    return { "code": code, "type": type, "message": message }
