import java.util.TreeSet

class MyCalendar {
    internal class Meeting(val start: Int, val end: Int) : Comparable<Meeting?> {
        override operator fun compareTo(other: Meeting?): Int {
            return start - other!!.start
        }
    }

    private val meetings: TreeSet<Meeting> = TreeSet()

    fun book(start: Int, end: Int): Boolean {
        val meetingToBook = Meeting(start, end)
        val prevMeeting = meetings.floor(meetingToBook)
        val nextMeeting = meetings.ceiling(meetingToBook)
        if ((prevMeeting == null || prevMeeting.end <= meetingToBook.start) &&
            (nextMeeting == null || meetingToBook.end <= nextMeeting.start)
        ) {
            meetings.add(meetingToBook)
            return true
        }
        return false
    }
}


/**
 * Your MyCalendar object will be instantiated and called as such:
 * var obj = MyCalendar()
 * var param_1 = obj.book(start,end)
 */