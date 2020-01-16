package ComparingDateTime;

import java.time.LocalDateTime;

public class Clock {

    public int day;
    public int hour;
    public int min;
    public int sec;

    private Clock(int d, int h, int m, int s) {
        day = d;
        hour = h;
        min = m;
        sec = s;
    }

    public static Clock getComparedTime(LocalDateTime scheduled, int day) {

        int nDays = LocalDateTime.now().getDayOfMonth();
        int sDays = scheduled.getDayOfMonth();
        int nHours = LocalDateTime.now().getHour();
        int sHours = scheduled.getHour();
        int nMins = LocalDateTime.now().getMinute();
        int sMins = scheduled.getMinute();
        int nSecs = LocalDateTime.now().getSecond();
        int sSecs = scheduled.getSecond();

        if(nHours < 12) {
            nHours += 1;
        }

        int comparedDays = 0;
        int comparedHours = 0;
        int comparedMins = 0;
        int comparedSecs = 0;

        if(sHours == 0 && sMins == 0 && sSecs == 0) {
            comparedHours += 24 - nHours;
            comparedMins += 60 - nMins;
            comparedSecs += 60 - nSecs;
        } else {
            if(sDays > nDays && sHours > nHours && sMins > nMins && sSecs > nSecs) {
                comparedDays += sDays - nDays;
                comparedHours += sHours - nHours;
                comparedMins += sMins - nMins;
                comparedSecs += sSecs - nSecs;

                //future
            } else if(sDays > nDays) {
                if(sHours > nHours) {
                    if(sSecs > nSecs) {
                        if(sMins < nMins) {
                            comparedSecs += sSecs - nSecs;
                            comparedMins += sMins + (60 - nMins);
                            comparedHours += sHours - nHours - 1;
                        }
                    } else if(sSecs < nSecs) {
                        if(sMins < nMins) {
                            comparedSecs += sSecs + (60 - nSecs);
                            comparedMins += sMins + (60 - nMins - 1);
                            comparedHours += sHours - nHours - 1;
                        } else if(sMins > nMins) {
                            comparedSecs += sSecs + (60 - nSecs);
                            comparedMins += sMins - nMins - 1;
                            comparedHours += sHours - nHours;
                        } else {
                            comparedSecs += sSecs + (60 - nSecs);
                            comparedMins += sMins - 1;
                            comparedHours += sHours - nHours;
                        }
                    } else {
                        if(sMins < nMins) {
                            comparedMins += sMins + (60 - nMins - 1);
                            comparedHours += sHours - nHours - 1;
                        } else if(sMins > nMins) {
                            comparedMins += sMins - nMins;
                            comparedHours += sHours - nHours;
                        } else {
                            comparedHours += sHours - nHours;
                        }
                    }
                    comparedDays += sDays - nDays;

                } else if(sHours < nHours) {
                    if(sSecs > nSecs) {
                        if(sMins < nMins) {
                            comparedSecs += sSecs - nSecs;
                            comparedMins += sMins + (60 - nMins);
                            comparedHours += sHours + (24 - nHours) - 1;
                        }
                    } else if(sSecs < nSecs) {
                        if(sMins < nMins) {
                            comparedSecs += sSecs + (60 - nSecs);
                            comparedMins += sMins + (60 - nMins - 1);
                            comparedHours += sHours + (24 - nHours) - 1;
                        } else if(sMins > nMins) {
                            comparedSecs += sSecs + (60 - nSecs);
                            comparedMins += sMins - nMins - 1;
                            comparedHours += sHours + (24 - nHours);
                        } else {
                            comparedSecs += sSecs + (60 - nSecs);
                            comparedMins += sMins - 1;
                            comparedHours += sHours + (24 - nHours);
                        }
                    }
                    comparedDays += sDays - nDays - 1;
                } else if(sHours == nHours) {
                    comparedDays += sDays - nDays - 1;
                    if(sSecs > nSecs) {
                        if(sMins < nMins) {
                            comparedSecs += sSecs - nSecs;
                            comparedMins += sMins + (60 - nMins);
                            comparedHours += (sDays - nDays) * 24;
                        } else {
                            comparedSecs += sSecs - nSecs;
                            comparedHours += (sDays - nDays) * 24;
                        }
                    } else if(sSecs < nSecs) {
                        if(sMins < nMins) {
                            comparedSecs += sSecs + (60 - nSecs);
                            comparedMins += sMins + (60 - nMins - 1);
                            comparedHours += (sDays - nDays) * 24 - 1;
                        } else if(sMins > nMins) {
                            comparedSecs += sSecs + (60 - nSecs);
                            comparedMins += sMins - nMins - 1;
                            comparedHours += (sDays - nDays) * 24;
                        } else {
                            comparedSecs += sSecs + (60 - nSecs);
                            comparedMins += sMins - 1;
                            comparedHours += (sDays - nDays) * 24;
                        }
                    }
                }
                //past
            } else if(sDays < nDays) {
                if(sHours < nHours) {
                    if(sSecs > nSecs) {
                        if(sMins > nMins) {
                            comparedSecs += sSecs + (60 - nSecs);
                            comparedMins += sMins + (60 - nMins) - 1;
                            comparedHours += nHours - sHours - 1;
                        } else if(sMins <= nMins) {
                            comparedSecs += sSecs + (60 - nSecs);
                            comparedMins += nMins - sMins - 1;
                            comparedHours += nHours - sHours;
                        }
                    } else if(sSecs < nSecs) {
                        if(sMins < nMins) {
                            comparedSecs += sSecs + (60 - nSecs);
                            comparedMins += nMins - sMins - 1;
                            comparedHours += nHours - sHours;
                        } else if(sMins >= nMins) {
                            comparedSecs += sSecs + (60 - nSecs);
                            comparedMins += sMins + (60 - nMins) - 1;
                            comparedHours += nHours - sHours;
                        }
                    }
                } else if(sHours == nHours) {
                    if(sMins > nMins) {
                        if(sSecs > nSecs) {
                            comparedMins += sMins - nMins;
                            comparedSecs += sSecs - nSecs;
                        } else if(sSecs < nSecs) {
                            comparedSecs += sSecs + (60 - nSecs);
                            comparedMins += sMins - nMins - 1;
                        } else if(sSecs == nSecs) {
                            comparedMins += sMins - nMins;
                        }
                    } else if(sMins < nMins) {
                        if(sSecs > nSecs) {
                            comparedSecs += -1 * (nSecs + (60 - sSecs));
                            comparedMins += -1 * (nMins - sMins);
                        } else if(sSecs < nSecs) {
                            comparedSecs += -1 * (nSecs - sSecs);
                            comparedMins += -1 * (nMins - sMins);
                        } else {
                            comparedMins += -1 * (nMins - sMins);
                        }
                    } else {
                        if(sSecs > nSecs) {
                            comparedSecs += -1 * (nSecs + (60 - sSecs));
                        } else {
                            comparedSecs += -1 * (nSecs - sSecs);
                        }
                    }
                }
                //day is same
            } else if(sDays == nDays) {
                if(sHours > nHours) {
                    if(sSecs > nSecs) {
                        if(sMins < nMins) {
                            comparedSecs += sSecs - nSecs;
                            comparedMins += sMins + (60 - nMins);
                            comparedHours += sHours - nHours - 1;
                        } else if(sMins == nMins) {
                            comparedSecs += sSecs - nSecs;
                            comparedHours += sHours - nHours;
                        }
                    } else if(sSecs < nSecs) {
                        if(sMins < nMins) {
                            comparedSecs += sSecs + (60 - nSecs);
                            comparedMins += sMins + (60 - nMins - 1);
                            comparedHours += sHours - nHours - 1;
                        } else if(sMins > nMins) {
                            comparedSecs += sSecs + (60 - nSecs);
                            comparedMins += sMins - nMins - 1;
                            comparedHours += sHours - nHours;
                        } else {
                            comparedSecs += sSecs + (60 - nSecs);
                            comparedMins += sMins - 1;
                            comparedHours += sHours - nHours;
                        }
                    }
                } else if(sHours < nHours) {
                    if(sSecs > nSecs) {
                        if(sMins < nMins) {
                            comparedSecs += sSecs - nSecs;
                            comparedMins += sMins + (60 - nMins);
                            comparedHours += sHours + (24 - nHours) - 1;
                        } else if(sMins == nMins) {
                            comparedSecs += sSecs - nSecs;
                            comparedHours += sHours + (24 - nHours);
                        }
                    } else if(sSecs < nSecs) {
                        if(sMins < nMins) {
                            comparedSecs += sSecs + (60 - nSecs);
                            comparedMins += sMins + (60 - nMins - 1);
                            comparedHours += sHours + (24 - nHours) - 1;
                        } else if(sMins > nMins) {
                            comparedSecs += sSecs + (60 - nSecs);
                            comparedMins += sMins - nMins - 1;
                            comparedHours += sHours + (24 - nHours);
                        } else {
                            comparedSecs += sSecs + (60 - nSecs);
                            comparedMins += sMins - 1;
                            comparedHours += sHours + (24 - nHours);
                        }
                    }
                } else if(nHours == sHours) {
                    if(sSecs > nSecs) {
                        if(sMins < nMins) {
                            comparedSecs += sSecs - nSecs;
                            comparedMins += sMins + (60 - nMins);
                        } else if(sMins > nMins) {
                            comparedSecs += sSecs - nSecs;
                            comparedMins += sMins - nMins;
                        } else {
                            comparedSecs += sSecs - nSecs;
                        }
                    } else if(sSecs < nSecs) {
                        if(sMins < nMins) {
                            comparedSecs += sSecs + (60 - nSecs);
                            comparedMins += sMins + (60 - nMins - 1);
                        } else if(sMins > nMins) {
                            comparedSecs += sSecs + (60 - nSecs);
                            comparedMins += sMins - nMins - 1;
                        } else {
                            comparedSecs += sSecs + (60 - nSecs);
                            comparedMins += sMins - 1;
                        }
                    }
                }
            }
        }

        comparedDays += day;

        if(comparedSecs >= 60) {
            comparedSecs -= 60;
            comparedMins += 1;
        }
        if(comparedMins >= 60) {
            comparedMins -= 60;
            comparedHours += 1;
        }
        if(comparedHours >= 24) {
            int eee = comparedHours / 24;
            comparedHours -= 24 * eee;
            comparedDays += eee;
        }
        if(comparedHours > 0 && comparedDays != 0) {
            comparedDays -= 1;
        }
        return new Clock(comparedDays, comparedHours, comparedMins, comparedSecs);
    }
    /*static int getComparedHours(LocalDateTime scheduled) {
        getComparedTime(scheduled);
        return comparedHours;
    }
    static int getComparedMins(LocalDateTime scheduled) {
        getComparedTime(scheduled);
        return comparedMins;
    }
    static int getComparedSecs(LocalDateTime scheduled) {
        getComparedTime(scheduled);
        return comparedSecs;
    }*/

   /* static int getComparedMinutes(int now, int scheduled) {
        int minutes = now - scheduled;
        int comparedMinutes;

        if (comparedHours )

        if (minutes < 0) {
            comparedMinutes = Math.abs(minutes);
        } else if (minutes > 60) {
            comparedMinutes = 69;
        } else if (scheduled == 0) {
            comparedMinutes = 60 - now;
        } else {
            comparedMinutes = -1 * minutes;
        }

        return comparedMinutes;
    }*/
}
