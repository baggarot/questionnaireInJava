package questionnaire.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import questionnaire.model.PollResult;
import questionnaire.repository.PollResultRepository;
import questionnaire.service.PollResultService;


@Service
@RequiredArgsConstructor
public class PollResultServiceImpl implements PollResultService {

    private final PollResultRepository resultRepository;

    @Override
    public void saveResult(PollResult pollResult) {
        resultRepository.save(pollResult);
    }

    @Override
    public PollResult findLastResult() {
        return resultRepository.findLastBy();
    }
}
