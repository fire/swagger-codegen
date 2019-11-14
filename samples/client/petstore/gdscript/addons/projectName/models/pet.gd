extends Reference
class_name Pet

var id
var category
var name
var photo_urls
var tags
var status

func get_array():
    return [ id, category, name, photo_urls, tags, status ]

func get_dict():
    return { "id": id, "category": category, "name": name, "photo_urls": photo_urls, "tags": tags, "status": status }
