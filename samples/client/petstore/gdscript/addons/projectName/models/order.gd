extends Reference
class_name Order

var id
var pet_id
var quantity
var ship_date
var status
var complete

func get_array():
    return [ id, pet_id, quantity, ship_date, status, complete ]

func get_dict():
    return { "id": id, "pet_id": pet_id, "quantity": quantity, "ship_date": ship_date, "status": status, "complete": complete }
