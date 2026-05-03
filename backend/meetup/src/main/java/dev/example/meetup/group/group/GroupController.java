package dev.example.meetup.group.group;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/groups/")
class GroupController {

    private List<Group> groups =  new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong();

    public GroupController() {
        groups.add(new Group(
                idCounter.getAndIncrement(),
                "Java user group",
                "Java users do stuff",
                "Stockholm",
                "pelle kula",
                LocalDate.of(2010, 3, 15)
        ));

        groups.add(new Group(
                idCounter.getAndIncrement(),
                "Python user group",
                "Python users do stuff",
                "Göteborg",
                "Palle kula",
                LocalDate.of(2010, 3, 15)
        ));
        groups.add(new Group(
                idCounter.getAndIncrement(),
                "c++ user group",
                "c++ users do stuff",
                "Umeå",
                "pelle kula",
                LocalDate.of(2011, 3, 15)
        ));
        groups.add(new Group(
                idCounter.getAndIncrement(),
                "c user group",
                "c users do stuff",
                "Umeå",
                "pelle kula",
                LocalDate.of(1992, 3, 15)
        ));
    }
    @GetMapping("/")
    List<Group> getAllGroups() {
        return groups;
    }

    @GetMapping("/{id}")
    Optional<Group> getGroupById(@PathVariable Long id) {
        return groups.stream()
                .filter(g-> g.id().equals(id))
                .findFirst();
    }
}
