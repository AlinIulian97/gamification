package beams.controller;

import beams.entity.enums.EnumDifficulty;
import beams.model.tokens.DifficultyUpdate;
import beams.model.tokens.TokensRequest;
import beams.model.tokens.TokensResponse;
import beams.service.TokensService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/token")
public class TokenController {

    private final TokensService tokensService;

    @PostMapping("/create")
    public TokensResponse createToken(@RequestBody TokensRequest tokensRequest) {
        return tokensService.createTokens(tokensRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteToken(@PathVariable Long id) {
        tokensService.deleteToken(id);
    }

    @GetMapping("/get/{id}")
    public TokensResponse getToken(@PathVariable Long id) {
        return tokensService.getTokens(id);
    }

    @PatchMapping("/updateDifficulty/{id}")
    public void difficultyUpdate(@PathVariable Long id, @RequestBody DifficultyUpdate enumDifficulty) {
        tokensService.updateDifficulty(id, enumDifficulty);
    }

    @GetMapping("/getAll")
    public List<TokensResponse> getAllToken() {
        return tokensService.getAllTokens();
    }
}
