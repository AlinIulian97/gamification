package beams.controller;

import beams.model.badges.BadgeRequest;
import beams.model.badges.BadgeResponse;
import beams.model.badges.BadgeUpdateNameResponse;
import beams.service.BadgeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/badge")
public class BadgeController {
    private final BadgeService badgesService;

    @PostMapping("/createBadge")
    private BadgeResponse createBadge(@RequestBody BadgeRequest badgeRequest) {
        return badgesService.createBadges(badgeRequest);
    }

    @DeleteMapping("/deleteBadge/{id}")
    public void deleteBadge(@PathVariable Long id) {
        badgesService.deleteBadge(id);
    }

    @PatchMapping("/update/{id}")
    public void updateName(@PathVariable Long id ,@RequestBody BadgeUpdateNameResponse email){
        badgesService.updatePassword(id, email);
    }

    @GetMapping("/badges")
    private List<BadgeResponse> badges() {
        return badgesService.getAllBadges();
    }

    @GetMapping("/get/{id}")
    private BadgeResponse getBadge(@PathVariable Long id) {
        return badgesService.getBadge(id);
    }

}
