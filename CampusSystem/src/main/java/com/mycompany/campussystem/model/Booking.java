package com.mycompany.campussystem.model;

/** A booking created from a request. */
public class Booking {

    private String bookingId;
    private Request request;
    private BookingStatus status;

    public Booking(String bookingId, Request request, BookingStatus status) {
        this.bookingId = bookingId;
        this.request = request;
        this.status = status;
    }

    public String getBookingId() { return bookingId; }
    public Request getRequest() { return request; }
    public BookingStatus getStatus() { return status; }
    public void setStatus(BookingStatus status) { this.status = status; }

    @Override
    public String toString() {
        return bookingId + ": " + request + " -> " + status;
    }
}
