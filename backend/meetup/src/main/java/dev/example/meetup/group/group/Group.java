package dev.example.meetup.group.group;

import java.time.LocalDate;

public record Group(Long id, String name, String description, String city, String organizer, LocalDate createdDate) {
}
