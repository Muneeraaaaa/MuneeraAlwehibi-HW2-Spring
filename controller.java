package com.example.springhw2;

import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class controller {

    ArrayList<TaskId> mytasks = new ArrayList<>();

    @PostMapping("/tasks")
    public api addtask(@RequestBody TaskId thenew) {

        mytasks.add(thenew);

        return new api("its added ");
    }

    @GetMapping("/tasks")
    public ArrayList showtasks() {

        return mytasks;
    }

    @PutMapping("/tasks/{index}")
    public api update(@PathVariable int index, @RequestBody TaskId updat) {

        mytasks.set(index, updat);
        return new api("its been updated");

    }

    @DeleteMapping("/tasks/{index}")
    public api delete(@PathVariable int index) {

        mytasks.remove(index);
        return new api("it id delted ");

    }

    @PutMapping("/tasks/{index}")
    public api chandstatus(@PathVariable int index, @RequestBody String status) {

        TaskId m1 = mytasks.get(index);
        m1.setStatus(status);
        return new api("it id delted ");

    }

    @GetMapping("/tasks")
    public TaskId search(@RequestBody String tittle) {

        for (int i = 0; i < mytasks.size(); i++) {

            if (tittle == mytasks.get(i).getTittle()) {

                return mytasks.get(i);
            }
        }
        new api("not found");
        return null;

    }
}