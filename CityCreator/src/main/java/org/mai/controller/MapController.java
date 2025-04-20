package org.mai.controller;

import lombok.RequiredArgsConstructor;
import org.mai.model.MapGraph;
import org.mai.model.Road;
import org.mai.service.MapService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/map")
@RequiredArgsConstructor
public class MapController {

    private final MapService mapService;

    @PostMapping("/city")
    public ResponseEntity<?> addCity(@RequestParam String name) {
        try {
            mapService.addCity(name);
            return ResponseEntity.ok("City added");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Change deletion command
    @DeleteMapping("/city/{name}")
    public ResponseEntity<?> deleteCity(@PathVariable String name) {
        try {
            mapService.deleteCity(name);
            return ResponseEntity.ok("City deleted");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/city")
    public ResponseEntity<?> renameCity(@RequestParam String oldName, @RequestParam String newName) {
        try {
            mapService.changeCityName(oldName, newName);
            return ResponseEntity.ok("City renamed");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/road")
    public ResponseEntity<?> addRoad(@RequestBody Road dto) {
        try {
            mapService.addRoad(dto.getFrom(), dto.getTo(), dto.getCost());
            return ResponseEntity.ok("Road added");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/road")
    public ResponseEntity<?> deleteRoad(@RequestBody Road dto) {
        try {
            mapService.deleteRoad(dto.getFrom(), dto.getTo(), dto.getCost());
            return ResponseEntity.ok("Road deleted");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/road")
    public ResponseEntity<?> updateRoad(@RequestParam String from,
                                        @RequestParam String to,
                                        @RequestParam int oldCost,
                                        @RequestParam int newCost) {
        try {
            mapService.changeRoadCost(from, to, oldCost, newCost);
            return ResponseEntity.ok("Road cost updated");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @PostMapping("/undo")
    public ResponseEntity<?> undo() {
        try {
            mapService.undo();
            return ResponseEntity.ok("Undo successful");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Nothing to undo");
        }
    }

    @PostMapping("/redo")
    public ResponseEntity<?> redo() {
        try {
            mapService.redo();
            return ResponseEntity.ok("Redo successful");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Nothing to redo");
        }
    }

    @GetMapping
    public MapGraph getMap() {
        return mapService.getMapGraph();
    }
}
