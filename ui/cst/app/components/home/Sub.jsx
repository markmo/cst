import { React, View, BackButton } from 'reapp-kit';
import { Container, Block } from 'reapp-ui/components/Grid';
import moment from 'moment';
import Markdown from 'react-remarkable';

export default class extends React.Component {
  render() {
    const store = this.context.store();
    const events = store.get('events');
    const time = this.props.state.params.time;
    const event = events.filter((ev) => ev.time == time)[0];
    const backButton =
      <BackButton onTap={() => window.history.back()} />

    return (
      <View {...this.props} title="Event Details" titleLeft={backButton}>
        <label style={{fontWeight: 'bold', color: 'cornflowerblue', marginTop: 20}}>{moment(event.time).format('D/M/YYYY')}</label>
        <h1 style={styles.h1}>{event.type + '-' + event.subtype}</h1>
        {event.reference &&
          <Container>
            <Block><label style={styles.label}>Reference</label></Block>
            <Block>{event.reference}</Block>
          </Container>
        }
        {event.agentName &&
          <Container>
            <Block><label style={styles.label}>Agent</label></Block>
            <Block>{event.agentName + ' (' + event.agentLanId + ') - ' + event.agentOu}</Block>
          </Container>
        }
        <Container>
          <Block><label style={styles.label}>Spoke To</label></Block>
          <Block>Elizabeth Marks</Block>
        </Container>
        {event.details &&
          <Container>
            <Block><label style={styles.label}>Details</label></Block>
            <Block><Markdown source={event.details}/></Block>
          </Container>
        }
      </View>
    );
  }
};

const styles = {
  h1: {
    marginTop: 4
  },
  label: {
    fontWeight: 'bold',
    color: 'cornflowerblue'
  }
};