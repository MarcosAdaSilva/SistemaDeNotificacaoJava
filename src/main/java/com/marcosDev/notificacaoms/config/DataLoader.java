package com.marcosDev.notificacaoms.config;

import com.marcosDev.notificacaoms.domain.enums.ChannelEnum;
import com.marcosDev.notificacaoms.domain.enums.StatusEnum;
import com.marcosDev.notificacaoms.domain.repository.ChannelRepository;
import com.marcosDev.notificacaoms.domain.repository.StatusRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DataLoader implements CommandLineRunner {

    private final ChannelRepository channelRepository;
    private final StatusRepository statusRepository;

    public DataLoader(ChannelRepository channelRepository,
                      StatusRepository statusRepository) {
        this.channelRepository = channelRepository;
        this.statusRepository = statusRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (channelRepository.count() == 0) {
            Arrays.stream(ChannelEnum.values())
                    .map(ChannelEnum::toChannel)
                    .forEach(channelRepository::save);
        }

        if (statusRepository.count() == 0) {
            Arrays.stream(StatusEnum.values())
                    .map(StatusEnum::toStatus)
                    .forEach(statusRepository::save);
        }
    }
}