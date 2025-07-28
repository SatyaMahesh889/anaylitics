package com.io.Events.dto;


public class Events {
   private EventDTO eventDTO;

   private  SessionDTO sessionDTO;

   private UserDTO userDTO;

    public Events(EventDTO eventDTO, SessionDTO sessionDTO, UserDTO userDTO) {
        this.eventDTO = eventDTO;
        this.sessionDTO = sessionDTO;
        this.userDTO = userDTO;
    }

    public Events() {
    }

    public EventDTO getEventDTO() {
        return eventDTO;
    }

    public void setEventDTO(EventDTO eventDTO) {
        this.eventDTO = eventDTO;
    }

    public SessionDTO getSessionDTO() {
        return sessionDTO;
    }

    public void setSessionDTO(SessionDTO sessionDTO) {
        this.sessionDTO = sessionDTO;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }
}
