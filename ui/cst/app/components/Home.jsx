import { Reapp, React, NestedViewList, View, Button, List, Title } from 'reapp-kit';
import EventListItem from './event-list-item';

class Home extends React.Component {

  componentWillMount() {
    const customerId = this.props.customerId || '2004226978';
    console.log('Loading events with customerId=' + customerId);
    this.action.loadEvents(customerId);
  }

  render() {
    const store = this.context.store();
    const events = store.get('events');
    return (
      <NestedViewList {...this.props.viewListProps}>
        <View title="What's been happening">
          <Title>Events for Elizabeth Marks</Title>
          {events.map &&
            <List>
              {events.map((event, i) =>
                <EventListItem index={i} item={event}/>
              )}
            </List>
          }
        </View>
        {this.props.child()}
      </NestedViewList>
    );
  }
}

export default Reapp(Home);

/*
 This is your root route. When you wrap it with Reapp()
 it passes your class two properties:

  - viewListProps: Passes the scrollToStep to your ViewList so it animates
  - child: The child route
*/
