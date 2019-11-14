extends Reference
class_name Category

var id
var name

func get_array():
    return [ id, name ]

func get_dict():
    return { "id": id, "name": name }
