import SockJS from "sockjs-client";
import { useEffect, useState } from "react";
import type { MatchUpdate } from "../types/odds";
import { Client } from "@stomp/stompjs";

export const useOddsSocket = () => {
  const [odds, setOdds] = useState<Record<string, MatchUpdate>>({});

  useEffect(() => {
    const socket = new SockJS("http://localhost:8080/ws-odds");
    const client = new Client({
      webSocketFactory: () => socket,
      onConnect: () => {
        console.log("Connected to VelocityOdds Server");
        client.subscribe("/topic/odds", (message) => {
          const update: MatchUpdate = JSON.parse(message.body);
          setOdds((prev) => ({
            ...prev,
            [update.matchId]: update,
          }));
        });
      },
    });

    client.activate();
    return () => client.deactivate();
  }, []);
  return odds;
};
