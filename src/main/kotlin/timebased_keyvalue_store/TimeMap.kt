package timebased_keyvalue_store


class TimeMap() {
    class Entry(val value: String, val timestamp: Int)

    val map = mutableMapOf<String, MutableList<Entry>>()

    fun set(key: String, value: String, timestamp: Int) {
        map.getOrPut(key) { mutableListOf() }.add(Entry(value, timestamp))
    }

    fun get(key: String, timestamp: Int): String {
        return map[key]
            ?.let { entries -> binarySearch(entries, timestamp) }
            ?: ""
    }

    private fun binarySearch(entries: List<Entry>, timestamp: Int): String {
        var low = 0
        var high = entries.size - 1
        var result = ""

        while (low <= high) {
            val mid = low + (high - low) / 2
            val currentEntry = entries[mid]

            if (currentEntry.timestamp == timestamp) {
                return currentEntry.value
            } else if (currentEntry.timestamp < timestamp) {
                result = currentEntry.value
                low = mid + 1
            } else {
                high = mid - 1
            }
        }

        return result
    }
}