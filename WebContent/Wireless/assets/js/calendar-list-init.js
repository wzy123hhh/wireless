$(document).ready(function() {

    $('#calendar-list').fullCalendar({
        header: {
            center: 'title',
            right: 'listDay,listWeek,listMonth'
        },

        // customize the button names,
        // otherwise they'd all just say "list"
        views: {
            listDay: { buttonText: '今日' },
            listWeek: { buttonText: '本周' },
            listMonth: {buttonText: '本月'}
        },

        defaultView: 'listDay',
        defaultDate: '2019-01-01',
        navLinks: true, // can click day/week names to navigate views
        editable: true,
        eventLimit: true, // allow "more" link when too many events
        events: [

            {
                title: 'Meeting-topic',
                start: '2019-01-01T10:30:00',
                end: '2017-11-12T12:30:00',
                className: "d-fc-event-blue"
            },
            {
                title: 'Meeting-topic',
                start: '2019-01-01T10:30:00',
                end: '2017-11-12T12:30:00',
                className: "d-fc-event-blue"
            },
            {
                title: 'Meeting-topic',
                start: '2019-01-01T10:30:00',
                end: '2017-11-12T12:30:00',
                className: "d-fc-event-blue"
            },
            {
                title: 'Meeting-topic',
                start: '2019-01-01T10:30:00',
                end: '2017-11-12T12:30:00',
                className: "d-fc-event-blue"
            },
            {
                title: 'Meeting-topic',
                start: '2019-01-01T10:30:00',
                end: '2017-11-12T12:30:00',
                className: "d-fc-event-blue"
            }
           

        ]
    });

});