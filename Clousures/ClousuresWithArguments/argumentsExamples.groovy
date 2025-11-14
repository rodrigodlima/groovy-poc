def processList(list, clousure) {
    list.each { item -> clousure(item)}
}

def printItem = {item -> 
    println "Processing item: $item"
}

processList(['banana', 'apple', 'orange'], printItem)