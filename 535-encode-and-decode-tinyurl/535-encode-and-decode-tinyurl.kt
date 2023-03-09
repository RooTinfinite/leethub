class Codec {
    private val map: MutableMap<String, String> = HashMap()
    private var n = 0

    // Encodes a URL to a shortened URL.
    fun encode(longUrl: String): String {
        n++
        var ans = "http://tinyurl.com/"
        ans += n.toString()
        map[ans] = longUrl
        return ans
    }

    // Decodes a shortened URL to its original URL.
    fun decode(shortUrl: String): String? {
        return map[shortUrl]
    }
}


/**
 * Your Codec object will be instantiated and called as such:
 * var obj = Codec()
 * var url = obj.encode(longUrl)
 * var ans = obj.decode(url)
 */