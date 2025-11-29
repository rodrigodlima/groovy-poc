StringBuilder sb = new StringBuilder()
sb.with {
    append("Hello")
    append("")
    append("World")
    toString()
}

// Same code without 'with'
StringBuilder sb2 = new StringBuilder() 
sb2.append('Hello') 
sb2.append(' ') 
sb2.append('World!') 
sb2.toString()