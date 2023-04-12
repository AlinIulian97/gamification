package beams.service;

import beams.entity.Badge;
import beams.entity.Tokens;
import beams.exception.BusinessException;
import beams.mapper.TokensMapper;
import beams.model.badges.BadgeRequest;
import beams.model.badges.BadgeResponse;
import beams.model.badges.BadgeUpdateNameResponse;
import beams.model.tokens.DifficultyUpdate;
import beams.model.tokens.TokensRequest;
import beams.model.tokens.TokensResponse;
import beams.repository.TokensRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class TokensService {
    private final TokensRepository tokensRepository;
    private final TokensMapper tokensMapper;


    public TokensResponse createTokens(TokensRequest tokensRequest) {
        Tokens createToken = tokensMapper.map(tokensRequest);
        tokensRepository.save(createToken);
        return tokensMapper.map(createToken);
    }

    public List<TokensResponse> getAllTokens() {
        return tokensMapper.map(tokensRepository.findAll());
    }

    public TokensResponse getTokens(Long id) {
        return tokensMapper.map(tokensRepository.findById(id).orElseThrow(
                () -> new BusinessException("Token is not found")));
    }


    public void deleteToken(Long id) {
        Tokens deleteToken = tokensRepository.findById(id).orElseThrow(
                () -> new BusinessException("Token is not found"));
        tokensRepository.delete(deleteToken);
    }

    public void updateDifficulty(Long id, DifficultyUpdate difficultyUpdate) {
        Tokens updateDifficultyToken = tokensRepository.findById(id).orElseThrow(
                () -> new BusinessException("Token is not found"));
        updateDifficultyToken.setEnumDifficulty(difficultyUpdate.getEnumDifficulty());
    }
}
