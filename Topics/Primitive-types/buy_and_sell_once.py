def buy_one(arr):
    if len(arr) < 1:
        return 0
    result = 0
    min = arr[0]
    for i in arr:
        if i <= min:
            min = i
        elif i - min > result:
            result = i - min
    return result

print(buy_one([310,315,275,295,260,270,290,230,255,250]))