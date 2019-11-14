extends Reference
class_name Tag

var id
var name

func get_array():
    return [ id, name ]

func get_dict():
    return { "id": id, "name": name }
