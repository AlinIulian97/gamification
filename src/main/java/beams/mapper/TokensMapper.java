package beams.mapper;

import antlr.Token;
import beams.entity.Quest;
import beams.entity.Tokens;
import beams.model.quest.QuestRequest;
import beams.model.quest.QuestResponse;
import beams.model.tokens.TokensRequest;
import beams.model.tokens.TokensResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface TokensMapper {

    Tokens map(TokensRequest tokensRequest);

    TokensResponse map(Tokens tokens);

    List<TokensResponse> map(List<Tokens> tokens);
}
