def text = "The quick brown fox jumps over the lazy dog." 
def pattern = /(\b[f|b]\w+)/ 
def matches = text.findAll(pattern) 
println(matches)